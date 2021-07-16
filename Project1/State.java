
/**
 * @author Khalil McCall
 *  N01043972
 *
 */
	public class State {
	/**
	 * fields for each state
	 */
		private String name;
		private String capital;
		private String abbreviation;
		private String region;
		private long population;
		private int houseSeats;
		/**
		 * constructor to save values
		 * @param name
		 * @param capital
		 * @param abbrevation
		 * @param region
		 * @param population
		 * @param houseSeats
		 */
		public State(String name, String capital, String abbrevation,String region, long population, int houseSeats) {

				this.name = name;

				this.capital = capital;

				this.abbreviation = abbrevation;

				this.region = region;

				this.population = population;

				this.houseSeats = houseSeats;

				}
		
		/**
		 * getters
		 * @return
		 */
		public String getName() {

			return name;

		}


		public String getCapital() {

			return capital;

		}

		public String getAbbreviation() {

			return abbreviation;

		}
		public int getHouseSeats() {

			return houseSeats;

		}

		public String getRegion() {

			return region;

		}
		public long getPopulation() {

			return population;

		}
		
		/**
		 * setters
		 * @param name
		 * @param capital
		 * @param abbreviation
		 * @param region
		 * @param population
		 */
		public void setName(String name) {

			this.name = name;

		}

		public void setCapital(String capital) {

			this.capital = capital;

		}

		public void setAbbreviation(String abbreviation) {

			this.abbreviation = abbreviation;

		}

		public void setRegion(String region) {

			this.region = region;

		}

		public void setPopulation(long population) {

			this.population = population;

		}

		
		public void setHouseSeats(int houseSeats) {

			this.houseSeats = houseSeats;

		}
		
/**
 * compares states
 */
		public int compareStates(State diff) {

			return this.getName().compareTo(diff.getName());

		}
/**
 * print state objects in certain string format
 */
		public String toString() {

		return String.format("%-25s %-17s %-15s %-12s %-16s %-12s", name , capital, abbreviation, population, region, houseSeats);
		}


		
		

	}