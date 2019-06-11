package cn.xingchen.mapper;

import cn.xingchen.model.OrderNodeInstances;
import cn.xingchen.model.OrderNodeInstancesExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderNodeInstancesMapper {
    @SelectProvider(type=OrderNodeInstancesSqlProvider.class, method="countByExample")
    long countByExample(OrderNodeInstancesExample example);

    @DeleteProvider(type=OrderNodeInstancesSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderNodeInstancesExample example);

    @Delete({
        "delete from parana_order_node_instances",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into parana_order_node_instances (id, fid, names, ",
        "`desc`, created_at, ",
        "updated_at, first_node)",
        "values (#{id,jdbcType=BIGINT}, #{fid,jdbcType=BIGINT}, #{names,jdbcType=VARCHAR}, ",
        "#{`desc`,jdbcType=VARCHAR}, #{created_at,jdbcType=TIMESTAMP}, ",
        "#{updated_at,jdbcType=TIMESTAMP}, #{first_node,jdbcType=TINYINT})"
    })
    int insert(OrderNodeInstances record);

    @InsertProvider(type=OrderNodeInstancesSqlProvider.class, method="insertSelective")
    int insertSelective(OrderNodeInstances record);

    @SelectProvider(type=OrderNodeInstancesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="fid", property="fid", jdbcType=JdbcType.BIGINT),
        @Result(column="names", property="names", jdbcType=JdbcType.VARCHAR),
        @Result(column="`desc`", property="`desc`", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="created_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updated_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="first_node", property="first_node", jdbcType=JdbcType.TINYINT)
    })
    List<OrderNodeInstances> selectByExample(OrderNodeInstancesExample example);

    @Select({
        "select",
        "id, fid, names, `desc`, created_at, updated_at, first_node",
        "from parana_order_node_instances",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="fid", property="fid", jdbcType=JdbcType.BIGINT),
        @Result(column="names", property="names", jdbcType=JdbcType.VARCHAR),
        @Result(column="`desc`", property="`desc`", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_at", property="created_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_at", property="updated_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="first_node", property="first_node", jdbcType=JdbcType.TINYINT)
    })
    OrderNodeInstances selectByPrimaryKey(Long id);

    @UpdateProvider(type=OrderNodeInstancesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderNodeInstances record, @Param("example") OrderNodeInstancesExample example);

    @UpdateProvider(type=OrderNodeInstancesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderNodeInstances record, @Param("example") OrderNodeInstancesExample example);

    @UpdateProvider(type=OrderNodeInstancesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderNodeInstances record);

    @Update({
        "update parana_order_node_instances",
        "set fid = #{fid,jdbcType=BIGINT},",
          "names = #{names,jdbcType=VARCHAR},",
          "`desc` = #{desc,jdbcType=VARCHAR},",
          "created_at = #{created_at,jdbcType=TIMESTAMP},",
          "updated_at = #{updated_at,jdbcType=TIMESTAMP},",
          "first_node = #{first_node,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderNodeInstances record);
}