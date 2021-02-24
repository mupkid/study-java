public class TestEnum {

	public void SortPlant(){
		/*// Using ordinal() to index into an array - DON'T DO THIS!
		Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
		for(int i=0; i<plantsByLifeCycle.length; i++){
			plantsByLifeCycle[i]=new HashSet<>();
		}
		for(Plant p:garden){
			plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
		}
		for(int i = 0; i<plantsByLifeCycle.length;i++){
			System.out.printf("%s:%s%n",Plant.LifeCycle.values()[i],plantsByLifeCycle[i]);
		}*/

		/*// Using an EnumMap to associate data with an enum
		Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
		for(Plant.LifeCycle lc : Plant.LifeCycle.values()){
			plantsByLifeCycle.put(lc,new HashSet<>());
		}
		for(Plant p : garden){
			plantsByLifeCycle.get(p.lifeCycle).add(p);
		}
		System.out.println(plantsByLifeCycle);

		//Naive stream-based approach - unlikely to produce an EnumMap
		System.out.println(Arrays.stream(garden).collect(groupingBy(p->p.lifeCycle)));

		//Using a stream and an EnumMap to associate data with an enum
		System.out.println(Arrays.stream(garden).collect(groupingBy(p->p.lifeCycle,
				()->new EnumMap<>(LifeCycle.class),toSet())));*/
	}
}
