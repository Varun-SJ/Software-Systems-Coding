package ss.week2;

public enum States {
		
		OFF (0),
		LOW (1),
		MED (2),
		FULL (3);
		
		private final int status;
		
		States (int state){
			
			status = state;
			
		}

		public int getStatus() {
			return status;
		}

	}


