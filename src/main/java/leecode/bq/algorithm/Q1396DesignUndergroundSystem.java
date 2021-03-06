package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/27/21 11:36 PM
 */
public class Q1396DesignUndergroundSystem {

    /**
     * Runtime: 143 ms, faster than 21.10% of Java online submissions for Design Underground System.
     * Memory Usage: 123.8 MB, less than 7.48% of Java online submissions for Design Underground System.
     */
    class UndergroundSystem {
        Map<Integer, Session> sessions;
        Map<String, JouneyStat> jouneyStats;

        public UndergroundSystem() {
            sessions = new HashMap<>();
            jouneyStats = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            sessions.put(id, new Session(id, stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Session session = sessions.get(id);
            session.end(stationName, t);

            String jouneyKey = buildJouneyKey(session.checkInStation, session.checkOutStation);
            jouneyStats.putIfAbsent(jouneyKey, new JouneyStat(jouneyKey));
            jouneyStats.get(jouneyKey).addJouney(session.getTime());

            sessions.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = buildJouneyKey(startStation, endStation);
            JouneyStat jouneyStat = jouneyStats.get(key);
            return jouneyStat.getAverage();
        }

        private String buildJouneyKey(String startStation, String endStation) {
            return new StringBuilder().append(startStation).append("-").append(endStation).toString();
        }


        class Session {
            int id;
            String checkInStation;
            int checkInTime;
            String checkOutStation;
            int checkOutTime;

            Session(int id, String station, int time) {
                this.id = id;
                this.checkInStation = station;
                this.checkInTime = time;
            }

            void end(String endStation, int time) {
                this.checkOutStation = endStation;
                this.checkOutTime = time;
            }

            int getTime() {
                return this.checkOutTime - this.checkInTime;
            }
        }

        class JouneyStat {
            String key;
            double totalTime = 0.0;
            double totalAmount = 0.0;

            JouneyStat(String key) {
                this.key = key;
            }

            public void addJouney(int time) {
                this.totalTime += time;
                this.totalAmount++;
            }

            public double getAverage() {
                return totalTime / totalAmount;
            }

        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

}
