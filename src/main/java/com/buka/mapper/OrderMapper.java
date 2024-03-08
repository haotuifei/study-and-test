package com.buka.mapper;

import com.buka.pojo.Film;
import com.buka.pojo.Movie;
import com.buka.pojo.Order;
import com.buka.pojo.Scheduling;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Select("select * from t_order")
    @Results({
            @Result(property = "orderId", column = "order_id", id = true),
            @Result(property = "orderNumber", column = "order_number"),
            @Result(property = "orderSchedulingId", column = "order_scheduling_id"),
            @Result(
                    property = "scheduling",
                    javaType = Scheduling.class,
                    column = "order_scheduling_id",
                    one = @One(select = "com.buka.mapper.SchedulingMapper.getSchedulingBySchedulingId")
            ),
            @Result(property = "orderMovieId", column = "order_movie_id"),
            @Result(
                    property = "movie",
                    javaType = Movie.class,
                    column = "order_movie_id",
                    one = @One(select = "com.buka.mapper.MovieMapper.selectMovieBySchedulingMovieId")
            ),
            @Result(property = "orderFilmId", column = "order_film_id"),
            @Result(
                    property = "film",
                    javaType = Film.class,
                    column = "order_film_id",
                    one = @One(select = "com.buka.mapper.FilmMapper.selectMovieBySchedulingFilmId")
            ),
            @Result(property = "orderSeat", column = "order_seat"),
            @Result(property = "orderTime", column = "order_time"),
            @Result(property = "orderMoney", column = "order_money"),
            @Result(property = "orderState", column = "order_state"),
            @Result(property = "payNum",column = "pay_num"),
            @Result(property = "orderUserId",column = "order_user_id")
    })
    List<Order> getAllOrder();

    @Select("select sum(order_money) from t_order where order_state = 2")
    int getAllMoney();

    @Select("select * from t_order where order_movie_id = #{movieId}")
    @Results({
            @Result(property = "orderId", column = "order_id", id = true),
            @Result(property = "orderNumber", column = "order_number"),
            @Result(property = "orderSchedulingId", column = "order_scheduling_id"),
            @Result(
                    property = "scheduling",
                    javaType = Scheduling.class,
                    column = "order_scheduling_id",
                    one = @One(select = "com.buka.mapper.SchedulingMapper.getSchedulingBySchedulingId")
            ),
            @Result(property = "orderMovieId", column = "order_movie_id"),
            @Result(
                    property = "movie",
                    javaType = Movie.class,
                    column = "order_movie_id",
                    one = @One(select = "com.buka.mapper.MovieMapper.selectMovieBySchedulingMovieId")
            ),
            @Result(property = "orderFilmId", column = "order_film_id"),
            @Result(
                    property = "film",
                    javaType = Film.class,
                    column = "order_film_id",
                    one = @One(select = "com.buka.mapper.FilmMapper.selectMovieBySchedulingFilmId")
            ),
            @Result(property = "orderSeat", column = "order_seat"),
            @Result(property = "orderTime", column = "order_time"),
            @Result(property = "orderMoney", column = "order_money"),
            @Result(property = "orderState", column = "order_state"),
            @Result(property = "payNum",column = "pay_num"),
            @Result(property = "orderUserId",column = "order_user_id")
    })
    List<Order> getAllOrderByMovieId(int movieId);

    @Select("select sum(order_money) from t_order where order_movie_id = #{movieId} and order_state = 2")
    int getAllMoneyByMovieId(int movieId);

    @Insert("insert into t_order values(null,#{orderNumber},#{orderSchedulingId},#{orderMovieId},#{orderFilmId},#{orderSeat},#{orderTime},#{orderMoney},#{orderState},#{payNum},#{orderUserId})")
    int addOrder(Order order);

    @Select("select order_state from t_order where pay_num = #{payNum}")
    int getStateByPayNum(String payNum);

    @Update("update t_order set order_state = 2 where pay_num = #{out_trade_no}")
    int payd(String out_trade_no);

    @Select("select order_id from t_order where pay_num = #{out_trade_no}")
    int getOrderIdByPayNum(String out_trade_no);

    @Update("update t_order set order_time = #{timestamp},pay_num = #{payNum} where order_number = #{orderNumber}")
    int updateorderByPayNum(@Param("timestamp") Timestamp timestamp, @Param("payNum") String payNum,@Param("orderNumber") String orderNumber);

    @Select("select * from t_order where order_user_id=#{userId}")
    @Results({
            @Result(property = "orderId", column = "order_id", id = true),
            @Result(property = "orderNumber", column = "order_number"),
            @Result(property = "orderSchedulingId", column = "order_scheduling_id"),
            @Result(
                    property = "scheduling",
                    javaType = Scheduling.class,
                    column = "order_scheduling_id",
                    one = @One(select = "com.buka.mapper.SchedulingMapper.getSchedulingBySchedulingId")
            ),
            @Result(property = "orderMovieId", column = "order_movie_id"),
            @Result(
                    property = "movie",
                    javaType = Movie.class,
                    column = "order_movie_id",
                    one = @One(select = "com.buka.mapper.MovieMapper.selectMovieBySchedulingMovieId")
            ),
            @Result(property = "orderFilmId", column = "order_film_id"),
            @Result(
                    property = "film",
                    javaType = Film.class,
                    column = "order_film_id",
                    one = @One(select = "com.buka.mapper.FilmMapper.selectMovieBySchedulingFilmId")
            ),
            @Result(property = "orderSeat", column = "order_seat"),
            @Result(property = "orderTime", column = "order_time"),
            @Result(property = "orderMoney", column = "order_money"),
            @Result(property = "orderState", column = "order_state"),
            @Result(property = "payNum",column = "pay_num"),
            @Result(property = "orderUserId",column = "order_user_id")
    })
    List<Order> getAllOrderByUserId(int userId);

    @Update("update t_order set order_state = 3 where pay_num = #{payNum}")
    int updateOrderStateByPaynum(String payNum);
}
