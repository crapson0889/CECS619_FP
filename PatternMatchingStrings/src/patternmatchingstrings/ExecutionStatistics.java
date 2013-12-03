/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package patternmatchingstrings;

import java.util.Date;

/**
 *
 * @author crapson
 */
public class ExecutionStatistics {
    private Date startTime;
    private Date endTime;
    
    public ExecutionStatistics(Date start)
    {
        startTime = start;
    }
    
    public void setEndTime(Date end)
    {
        if(endTime == null)
        {
            endTime = end;
        }
    }
    
    public long getRunTime()
    {
        return endTime.getTime() - startTime.getTime();
    }
}
