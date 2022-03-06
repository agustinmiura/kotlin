package ar.com.miura.lc.queue;

public class PeopleEating {
    public int countStudents(int[] students, int[] sandwiches) {
        java.util.Queue<Integer> people = new java.util.LinkedList();
        for(Integer student:students) {
            people.offer(student);
        }

        int size = students.length;
        int queueTimes = 0;

        int top = 0;

        while( !people.isEmpty() && queueTimes <= people.size() ) {
            if (people.peek() == sandwiches[top]) {
                top++;
                queueTimes = 0;
                people.poll();
            } else {
                people.add(people.poll());
                queueTimes++;
            }
        }
        return people.size();
    }
}
