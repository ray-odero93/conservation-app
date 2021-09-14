package models;

import org.sql2o.Sql2o;

public class DB {
   public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-50-17-255-244.compute-1.amazonaws.com:5432/ddr38cjsfgt0uq", "zjaanpjcapxdwn","e4ffa8fce21be355c5a7f8d6665bb1791c5bc4df6bc1398a6e0767f8fc0f9375");
}
