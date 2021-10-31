package ar.com.miura.aexpert

class TournameWinner {

    fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {

        var teamPoints = mutableMapOf<String,Int>();

        /**
         * Fill the teams
         **/
        for(competition in competitions) {
            for(team in competition) {
                teamPoints.put(team, 0);
            }
        }

        var key = "";
        var size = results.size;
        for(i in 0..(size-1)) {
            var match = competitions.get(i);
            var eachResult = results.get(i);

            if (eachResult==1) {
                key = match.get(0);
            } else {
                key = match.get(1);
            }

            var points = teamPoints.getOrDefault(key,0);
            points++;
            teamPoints.put(key,points);
        }

        var points = Int.MIN_VALUE;
        var winner:String = "";
        for((k,v) in teamPoints) {
            if (v>points) {
                points = v;
                winner = k;
            }
        }

        return winner;
    }

}