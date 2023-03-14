import java.lang.reflect.Type;
import java.util.*;

public class CollectionsDemo {
    public static int NumOfStarts(ArrayList<String> arrayList, String ch){
        int count = 0;
        for (String value: arrayList){
            if(value.startsWith(ch)){
                count++;
            }
        }
        return count;
    }
    public static ArrayList<Human> GetEqualsSurname(ArrayList<Human> arrayList, Human person){
        ArrayList<Human> result = new ArrayList<>();
        for (Human value: arrayList){
            if (value.getSurname().equals(person.getSurname())){
                result.add(value);
            }
        }
        return result;
    }
    public static ArrayList<Human> ExcludeHuman(ArrayList<Human> arrayList, Human person){
        ArrayList<Human> result = new ArrayList<>();
        for (int i = 0; i<arrayList.size(); i++){
            if (!arrayList.get(i).equals(person)){
                result.add(new Human(arrayList.get(i)));
            }
        }
        return result;
    }
    public static ArrayList<Set<Integer>> getNotIntersecting(ArrayList<Set<Integer>> initial, Set<Integer> compare){
        ArrayList<Set<Integer>> res = new ArrayList<>();
        boolean inter = true;
        for (Set<Integer> initialValue: initial){
            for (int value: compare){
                for (int intInSet: initialValue){
                    if(intInSet == value){
                        inter = false;
                        break;
                    }
                }
            }
            if (inter) res.add(initialValue);
            inter = true;
        }
        return res;
    }
    public static Set<Human> getSetWithMaxAge(ArrayList<Human> initial){
        int maxAge = 0;
        HashSet<Human> res = new HashSet<>();
        for (Human value: initial){
            if(value.getAge() > maxAge){
                maxAge = value.getAge();
            }
        }
        for (Human value: initial){
            if (value.getAge() == maxAge){
                res.add(value);
            }
        }
        return res;
    }
    public static Set<Human> getSetById(Map<Integer,Human> persons, Set<Integer> ids){
        HashSet<Human> res = new HashSet<>();
        for (int key: ids){
            if (persons.containsKey(key)){
                res.add(persons.get(key));
            }
        }
        return res;
    }
    public static Set<Integer> getIdsOfAdults(Map<Integer, Human> persons){
        HashSet<Integer> res = new HashSet<>();
        for (Map.Entry<Integer, Human> value: persons.entrySet()){
            if (value.getValue().getAge()>=18){
                res.add(value.getKey());
            }
        }
        return res;
    }

    public static Map<Integer, Integer> getMapWithAges(Map<Integer, Human> persons){
        Map<Integer, Integer> res = new HashMap<>();
        for (Map.Entry<Integer, Human> value: persons.entrySet()){
            res.put(value.getKey(), value.getValue().getAge());
        }
        return res;
    }

    public static Map<Integer, Set<Human>> getSetsOfHumanByAge(Set<Human> persons){
        Map<Integer,Set<Human>> res = new HashMap<>();
        for (Human value: persons){
            if (res.containsKey(value.getAge())){
                res.get(value.getAge()).add(value);
            } else {
                Set<Human> put = new HashSet<>();
                put.add(value);
                res.put(value.getAge(),put);
            }
        }
        return res;
    }
}
