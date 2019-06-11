package cn.xingchen.mapper;

import cn.xingchen.model.OrderNodeInstances;
import cn.xingchen.model.OrderNodeInstancesExample.Criteria;
import cn.xingchen.model.OrderNodeInstancesExample.Criterion;
import cn.xingchen.model.OrderNodeInstancesExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OrderNodeInstancesSqlProvider {

    public String countByExample(OrderNodeInstancesExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("parana_order_node_instances");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(OrderNodeInstancesExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("parana_order_node_instances");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(OrderNodeInstances record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("parana_order_node_instances");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getFid() != null) {
            sql.VALUES("fid", "#{fid,jdbcType=BIGINT}");
        }
        
        if (record.getNames() != null) {
            sql.VALUES("names", "#{names,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            sql.VALUES("desc", "#{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated_at() != null) {
            sql.VALUES("created_at", "#{created_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_at() != null) {
            sql.VALUES("updated_at", "#{updated_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFirst_node() != null) {
            sql.VALUES("first_node", "#{first_node,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OrderNodeInstancesExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("fid");
        sql.SELECT("names");
        sql.SELECT("desc");
        sql.SELECT("created_at");
        sql.SELECT("updated_at");
        sql.SELECT("first_node");
        sql.FROM("parana_order_node_instances");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        OrderNodeInstances record = (OrderNodeInstances) parameter.get("record");
        OrderNodeInstancesExample example = (OrderNodeInstancesExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("parana_order_node_instances");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getFid() != null) {
            sql.SET("fid = #{record.fid,jdbcType=BIGINT}");
        }
        
        if (record.getNames() != null) {
            sql.SET("names = #{record.names,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            sql.SET("desc = #{record.desc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated_at() != null) {
            sql.SET("created_at = #{record.created_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_at() != null) {
            sql.SET("updated_at = #{record.updated_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFirst_node() != null) {
            sql.SET("first_node = #{record.first_node,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("parana_order_node_instances");
        
        sql.SET("id = #{record.id,jdbcType=BIGINT}");
        sql.SET("fid = #{record.fid,jdbcType=BIGINT}");
        sql.SET("names = #{record.names,jdbcType=VARCHAR}");
        sql.SET("desc = #{record.desc,jdbcType=VARCHAR}");
        sql.SET("created_at = #{record.created_at,jdbcType=TIMESTAMP}");
        sql.SET("updated_at = #{record.updated_at,jdbcType=TIMESTAMP}");
        sql.SET("first_node = #{record.first_node,jdbcType=TINYINT}");
        
        OrderNodeInstancesExample example = (OrderNodeInstancesExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(OrderNodeInstances record) {
        SQL sql = new SQL();
        sql.UPDATE("parana_order_node_instances");
        
        if (record.getFid() != null) {
            sql.SET("fid = #{fid,jdbcType=BIGINT}");
        }
        
        if (record.getNames() != null) {
            sql.SET("names = #{names,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            sql.SET("desc = #{desc,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated_at() != null) {
            sql.SET("created_at = #{created_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdated_at() != null) {
            sql.SET("updated_at = #{updated_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFirst_node() != null) {
            sql.SET("first_node = #{first_node,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OrderNodeInstancesExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}