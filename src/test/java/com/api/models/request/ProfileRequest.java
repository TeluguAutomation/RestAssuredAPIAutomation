package com.api.models.request;

public class ProfileRequest {
	    private int id;
        private String username;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String mobileNumber;

	    // Default Constructor
	    public ProfileRequest() {
	    }

	    
	    public ProfileRequest(int id, String username, String firstName, String lastName, String email,
				String mobileNumber) {
			super();
			this.id = id;
			this.username = username;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.mobileNumber = mobileNumber;
		}


		// Getters and Setters
	    

	    public String getFirstName() {
	        return firstName;
	    }

	    public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getMobileNumber() {
	        return mobileNumber;
	    }

	    public void setMobileNumber(String mobileNumber) {
	        this.mobileNumber = mobileNumber;
	    }

		
		
		@Override
		public String toString() {
			return "ProfileRequest [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
					+ lastName + ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
		}



		// Builder class
	    public static class Builder {
	    	private int id;
	        private String username;
	        private String firstName;
	        private String lastName;
	        private String email;
	        private String mobileNumber;
	        
	        public Builder setId(int id) {
	            this.id = id;
	            return this;
	        }

	        public Builder setUsername(String username) {
	            this.username = username;
	            return this;
	        }


	        public Builder setFirstName(String firstName) {
	            this.firstName = firstName;
	            return this;
	        }

	        public Builder setLastName(String lastName) {
	            this.lastName = lastName;
	            return this;
	        }

	        public Builder setEmail(String email) {
	            this.email = email;
	            return this;
	        }

	        public Builder setMobileNumber(String mobileNumber) {
	            this.mobileNumber = mobileNumber;
	            return this;
	        }

	        public ProfileRequest build() {
	        	ProfileRequest profileRequest= new ProfileRequest(id, username, firstName, lastName, email, mobileNumber);
	            return profileRequest;
	        }
	    }
	    
}
