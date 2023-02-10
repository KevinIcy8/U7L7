import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        schedule = new ArrayList<CarRepair>();
        numberOfMechanics = n;
    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        CarRepair car = new CarRepair(m, b);
        for(int i = 0; i < schedule.size(); i++){
            CarRepair mechanic = schedule.get(i);
            if(mechanic.getMechanicNum() == m || mechanic.getBayNum() == b){
                return false;
            }
        }
        schedule.add(car);
        return true;

    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        ArrayList<Integer> availableMechanics = new ArrayList<Integer>();
        for(int i = 0; i < numberOfMechanics; i++){
            if(schedule.get(i).getMechanicNum() != availableMechanics.get(i)) {
                availableMechanics.add(i);
            }
        }
        int index = 0;
        for(int i = 0; i < schedule.size(); i++){
            if(schedule.get(i).getMechanicNum() == availableMechanics.get(index)){
                availableMechanics.remove(index);
                //index--;
            }
            index++;
            i--;

        }
        return availableMechanics;
    }

    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}