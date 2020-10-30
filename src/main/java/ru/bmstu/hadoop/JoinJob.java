package ru.bmstu.hadoop;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class JoinJob {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Airport flight statistics");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> totalFile = sc.textFile("664600583_T_ONTIME_sample.csv");
        JavaRDD<String> airportNames = sc.textFile("L_AIRPORT_ID.csv");
        JavaRDD<String, String> airports = totalFile.mapToPair()
    }
}
