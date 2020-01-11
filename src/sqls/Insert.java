package sqls;

public class Insert {

    private static String convertToString(String[] fields){
        String sql = "";
        for (int i=0;i<fields.length;i++){
            if (i == fields.length-1){
                sql = sql + fields[i];
            }
            else{
                sql = sql + fields[i] + ", ";
            }
        }
        return sql;
    }

    public static String setFields(String ... fields){
        return convertToString(fields);
    }

    public static String setValues(String ... values){
        for (int i=0;i<values.length;i++){
            try{
                Integer.parseInt(values[i]);
            }catch (Exception e){
                values[i] = "'"+values[i]+"'";
            }
        }
        return convertToString(values);
    }

    public static String insert(String table, String fields, String values){
        String sql = "Insert into " + table + " (" + fields + ")"
                + " values (" + values + ") ";
        System.out.println(sql);
        return sql;
    }
}
