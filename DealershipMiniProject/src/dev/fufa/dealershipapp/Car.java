package dev.fufa.dealershipapp;

	public class Car {
		
		private String make;
		private String model;
		private int year;
		private int value;
		private int mileage;
			
		Car(String make, String model, int year, int value, int mileage){
			this.make = make;
			this.model = model;
			this.year = year;
			this.value = value;
			this.mileage = mileage;
		}
		
		public void showStats() {
			System.out.println("make : " + this.make +" model: "+ this.model +"value :" +
					this.value + " year : " +this.year + " mileage :" + this.mileage);
		}

		public String getMake() {
			return make;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getMileage() {
			return mileage;
		}

		public void setMileage(int mileage) {
			
			if(mileage<0) {
				this.mileage = 0;
			}else {
				this.mileage = mileage;
			}

		}

		
	}

