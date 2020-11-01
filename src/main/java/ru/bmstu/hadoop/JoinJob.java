package ru.bmstu.hadoop;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class JoinJob {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Airport flight statistics");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> totalData = sc.textFile("664600583_T_ONTIME_sample.csv");
        JavaRDD<String> airportNames = sc.textFile("L_AIRPORT_ID.csv");

        int row = 0;
        JavaPairRDD<String, Integer> pairTotalData = totalData.mapToPair(s -> new Tuple2<>(s, 1));
        JavaPairRDD<String, Integer> pairAirportNames = airportNames.mapToPair();

        JavaRDD<ParsedData> parsedTotalData = totalData.map(s -> new ParsedData(s.split(",")));
        JavaRDD<ParsedNames> parsedAirportNames = airportNames.map(s -> new ParsedNames(s.split(",")));
    }
}
