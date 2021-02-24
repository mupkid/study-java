/**
 * Using ordinal() to index array of arrays - DON'T DO THIS;
 */
/*public enum Phase {
	SOLID, LIQUID, GAS;

	public enum Transition{
		MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

		private static final Transition[][] TRANSITIONS= {
				{null,MELT,SUBLIME},
				{FREEZE,null,BOIL},
				{DEPOSIT,CONDENSE,null}
		};

        // Returns the phase transition from one phase to another
		public static Transition from(Phase from, Phase to){
			return TRANSITIONS[from.ordinal()][to.ordinal()];
		}
	}
}*/

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

/**
 * Using a nested EnumMap to associate data with enum pairs
 */
public enum Phase{
	SOLID, LIQUID, GAS;

	public enum Transition{
		MELT(SOLID,LIQUID), FREEZE(LIQUID,SOLID),
		BOIL(LIQUID,GAS),CONDENSE(GAS,LIQUID),
		SUBLIME(SOLID,GAS),DEPOSIT(GAS,SOLID);

		private final Phase from;
		private final Phase to;

		Transition(Phase from, Phase to){
			this.from=from;
			this.to=to;
		}

		/**
		 * Initialize the phase transition map
		 */
		private static final Map<Phase, Map<Phase,Transition>> m =
				Stream.of(values()).collect(groupingBy(t -> t.from,
						()-> new EnumMap<Phase, Map<Phase, Transition>>(Phase.class),
						toMap(t->t.to,t->t,(x, y)->y,()->new EnumMap<Phase, Transition>(Phase.class))));

		public static Transition from(Phase from, Phase to){
			return m.get(from).get(to);
		}
	}
}