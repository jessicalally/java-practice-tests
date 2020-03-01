package aeroplane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SeatAllocator {

	private Map<Seat, Passenger> allocation;

	private static final String CREW = "crew";
	private static final String BUSINESS = "business";
	private static final String ECONOMY = "economy";
	private static final Seat FIRST_CREW = new Seat(1, 'A');
	private static final Seat LAST_CREW = new Seat(1, 'F');
	private static final Seat FIRST_BUSINESS = new Seat(2, 'A');
	private static final Seat LAST_BUSINESS = new Seat(15, 'F');
	private static final Seat FIRST_ECONOMY = new Seat(16, 'A');
	private static final Seat LAST_ECONOMY = new Seat(50, 'F');

	public SeatAllocator() {
		allocation = new HashMap<Seat, Passenger>();
	}

	@Override
	public String toString() {
		return allocation.toString();
	}
	
	private void allocateInRange(Passenger passenger,
			Seat first, Seat last) throws AeroplaneFullException {
		// TODO: Section A, Task 4
		Seat current = first;
		while (current.hasNext()){
			if (!allocation.containsKey(current)){
				if (passenger.isAdult() || !current.isEmergencyExit()){
					allocation.put(current, passenger);
					return;
				}
			}
			if (current.equals(last)){
				return;
			}
			current = current.next();
		}

		throw new AeroplaneFullException();
	}

	private static String readStringValue(BufferedReader br) throws MalformedDataException, IOException {

		String result = br.readLine();
		
		if(result == null) {
			throw new MalformedDataException();
		}
		
		return result;
		
	}

	private static int readIntValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Integer.parseInt(readStringValue(br));
		} catch(NumberFormatException e) {
			throw new MalformedDataException();
		}
	}

	private static Luxury readLuxuryValue(BufferedReader br)
			throws MalformedDataException, IOException {
		try {
			return Luxury.valueOf(readStringValue(br));
		} catch(IllegalArgumentException e) {
			throw new MalformedDataException();
		}
	}

	
	public void allocate(String filename) throws IOException, AeroplaneFullException {
		
		BufferedReader br = new BufferedReader(new FileReader(filename));

		String line;
		while((line = br.readLine()) != null) {
			try {
				if(line.equals(CREW)) {
					allocateCrew(br);
				} else if(line.equals(BUSINESS)) {
					allocateBusiness(br);
				} else if(line.equals(ECONOMY)) {
					allocateEconomy(br);
				} else {
					throw new MalformedDataException();
				}
			} catch(MalformedDataException e) {
				System.out.println("Skipping malformed line of input");
			}
		}
		
	}
	
	private void allocateCrew(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		// TODO: Section A, Task 4
		//       create a crew member using firstName and lastName
		//       call allocateInRange with appropriate arguments
		CrewMember crewMember = new CrewMember(firstName, lastName);
		allocateInRange(crewMember, FIRST_CREW, LAST_CREW);
	}

	private void allocateBusiness(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		Luxury luxury = readLuxuryValue(br);
		// TODO: Section A, Task 4
		//       create a business class passenger using firstName, lastName, age and luxury
		//       call allocateInRange with appropriate arguments
		BusinessClassPassenger newPassenger = new BusinessClassPassenger(firstName, lastName, age, luxury);
		allocateInRange(newPassenger, FIRST_BUSINESS, LAST_BUSINESS);
	}

	private void allocateEconomy(BufferedReader br) throws IOException, MalformedDataException, AeroplaneFullException {
		String firstName = readStringValue(br);
		String lastName = readStringValue(br);
		int age = readIntValue(br);
		// TODO: Section A, Task 4
		//       create an economy class passenger using firstName, lastName and age
		//       call allocateInRange with appropriate arguments
	EconomyClassPassenger newPassenger = new EconomyClassPassenger(firstName, lastName, age);
	allocateInRange(newPassenger, FIRST_ECONOMY, LAST_ECONOMY);
	}

	// TODO: Section A, Task 5 - add upgrade method
	public void upgrade(){
		Seat current = FIRST_ECONOMY;
		while (current.hasNext()){
			if (allocation.containsKey(current)){
				Passenger passenger = allocation.remove(current);
				try {
					allocateInRange(passenger, FIRST_BUSINESS, LAST_BUSINESS);
				} catch (AeroplaneFullException e){
					break;
				}
			}
			current = current.next();
		}
	}

}
