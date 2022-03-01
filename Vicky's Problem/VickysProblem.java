import java.util.Scanner;

public class VickysProblem{
	public static void main(String[] args){
		System.out.println("Enter the distance the frog has to jump");
		Scanner sc = new Scanner(System.in);

		//Making sure that the user inputs an integer value.
		while((!sc.hasNextInt())){
			System.out.println("Please enter an integer");
			sc = new Scanner(System.in);
			
		}
		int distance = sc.nextInt();
		int timeTaken = solution(distance);
		System.out.printf("The time taken to jump %d meters is %d seconds",distance,timeTaken);
	}

	public static int solution(int distance){
		int distTimeArr[][] = {{5,1},{3,2},{1,3}};
		int i = distTimeArr.length;
		int index = 0;
		int time = 0;
		while(distance>0){
			//Looping the array infinitely 
			index = i % distTimeArr.length;
			
			distance -= distTimeArr[index][0];

			//The rest time after passing the distance would not be added.
			if(distance - distTimeArr[index][0] < 0){
				return time;
			}

			time += distTimeArr[index][1];
			i++;
		}
		//Return 0 if a negative distance was provided.
		return 0;
	}
}
