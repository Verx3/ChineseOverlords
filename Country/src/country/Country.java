
public class Country {
	String name;
	double GDP;
	double population;
	double amountInj;
	double amountDebt;
	private static final int CLASS_CONS1 = 1000;
	private static final int CLASS_CONS2 = 10000;
	final String END_OF_LINE = System.lineSeparator();
	
	
	Country (String name, double GDP, double population){
		this.name=name;
		this.GDP=GDP;
		this.population=population;
	}

	public String getName() {
		return name;
	}

	public double getGDP() {
		return GDP;
	}

	public double getPopulation() {
		return population;
	}

	public void setName(String newname) {
	        this.name = newname;
	}

	public void setPopulation(double newpopulation) {
	        this.population = newpopulation;
	}
	
	public double gdp_per_capita() {
		double gdpCap;
		gdpCap= GDP/population;
		return gdpCap;
	}
	
	public String getClassification() {
		String classification="";
		if (gdp_per_capita()>= CLASS_CONS2) {
			classification="Developed country";
		}else if ((gdp_per_capita()>= CLASS_CONS1)&&(CLASS_CONS2 >gdp_per_capita())) {
			classification="Economy in transition";
		}else if (gdp_per_capita()< CLASS_CONS1) {
			classification="Developing country";
		}
		
		return classification;
	}

	public void injectMoney(double amountInj) {
		if (amountInj > 0) {
			GDP = amountInj + GDP;
		 	}
			else {System.out.println("Error when injecting money in "+this.name+ ". Amount has to be higher than zero");
		}
	}

	public void payDebt(double amountDebt ) {
		if (amountDebt<0 || amountDebt>GDP) {
			System.out.println("Error when paying "+this.name+ "'s debt. Amount has to be higher than zero");
		}else  if (amountDebt>0) {
			GDP = GDP- amountDebt;
		}
		
	}

	@Override
	public String toString() {
		String print = this.name + " : ( "+ getClassification() + " )" +END_OF_LINE;
		print+= "Population : "+ getPopulation() + END_OF_LINE;
		print+= "GDP : "+ getGDP() + END_OF_LINE;
		print+=gdp_per_capita() + "GDP per capita ."+ END_OF_LINE;
		print+= "    ";
		
		return print;
	} 

}


