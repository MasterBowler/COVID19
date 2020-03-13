package com.company;
//https://profs.info.uaic.ro/~acf/java/labs/slides/lab_04.pdf
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //cant use var with java 8
        Resident[] r = IntStream.rangeClosed(0,4).mapToObj(i -> new Resident("R"+i)).toArray(Resident[]::new);
        Hospital[] h = IntStream.rangeClosed(0,3).mapToObj(i->new Hospital("H"+i)).toArray(Hospital[]::new);

        List<Resident> residentList = new ArrayList<>();
        for(Resident res:r) {
            residentList.add(res);
        }

        Collections.sort(residentList, new Comparator<Resident>() {
            @Override
            public int compare(Resident o1, Resident o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        Set<Hospital> hospitalSet = new TreeSet<>();
        for(Hospital hospital: h) {
            hospitalSet.add(hospital);
        }

        Map<Resident,List<Hospital>> resPrefMap = new HashMap<>();
        resPrefMap.put(r[0],Arrays.asList(h[0],h[1],h[2]));
        resPrefMap.put(r[1],Arrays.asList(h[0],h[1],h[2]));
        resPrefMap.put(r[2],Arrays.asList(h[0],h[1]));
        resPrefMap.put(r[3],Arrays.asList(h[0],h[2]));

        Map<Hospital,List<Resident>> hosPrefMap = new TreeMap<>();
        hosPrefMap.put(h[0],Arrays.asList(r[3],r[0],r[1],r[2]));
        hosPrefMap.put(h[1],Arrays.asList(r[0],r[2],r[1]));
        hosPrefMap.put(h[2],Arrays.asList(r[0],r[1],r[3]));

        System.out.println(resPrefMap);
        System.out.println(hosPrefMap);

        residentList.stream().filter(res -> resPrefMap.get(res).containsAll(Arrays.asList(h[0],h[1]))).forEach(System.out::println);
    }
}
