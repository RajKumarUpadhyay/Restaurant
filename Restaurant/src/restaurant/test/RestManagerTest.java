package restaurant.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import restaurant.CustomerGroup;
import restaurant.RestManager;
import restaurant.Table;


public class RestManagerTest {


    private RestManager restManager;
    private List<Table> tables;

    @Before
    public void setUp() {
        tables = new ArrayList<Table>();
        tables.add(new Table(6));
        tables.add(new Table(2));
        tables.add(new Table(4));
        restManager = new RestManager(tables);
    }

    @Test
    public void testSeatOneGroup() {
       
        CustomerGroup group = new CustomerGroup(2);
        boolean result = this.restManager.onArrive(group);
        Assert.assertTrue(result);
        Assert.assertNotNull(group.getAssignedTable());
        Assert.assertEquals(group.getAssignedTable().getSize(), 2);
    }

    @Test
    public void testSeatTwoGroups() {
        
        CustomerGroup group2 = new CustomerGroup(2);
        boolean result2 = this.restManager.onArrive(group2);
        Assert.assertTrue(result2);
        Assert.assertNotNull(group2.getAssignedTable());
        Assert.assertEquals(group2.getAssignedTable().getSize(), 2);
        // Seat group of six
        CustomerGroup group6 = new CustomerGroup(6);
        boolean result6 = this.restManager.onArrive(group6);
        Assert.assertTrue(result6);
        Assert.assertNotNull(group6.getAssignedTable());
        Assert.assertEquals(group6.getAssignedTable().getSize(), 6);
    }

    @Test
    public void testSeatThreeGroups() {
        // Seat group of two
        CustomerGroup group2 = new CustomerGroup(2);
        boolean result2 = this.restManager.onArrive(group2);
        Assert.assertTrue(result2);
        Assert.assertNotNull(group2.getAssignedTable());
        Assert.assertEquals(group2.getAssignedTable().getSize(), 2);
        // Seat group of six
        CustomerGroup group6 = new CustomerGroup(6);
        boolean result6 = this.restManager.onArrive(group6);
        Assert.assertTrue(result6);
        Assert.assertNotNull(group6.getAssignedTable());
        Assert.assertEquals(group6.getAssignedTable().getSize(), 6);
        // Seat group of four
        CustomerGroup group4 = new CustomerGroup(4);
        boolean result4 = this.restManager.onArrive(group4);
        Assert.assertTrue(result4);
        Assert.assertNotNull(group4.getAssignedTable());
        Assert.assertEquals(group4.getAssignedTable().getSize(), 4);
    }

    @Test
    public void testNotAvailableSeats() {
        // Seat group of two
        CustomerGroup group2 = new CustomerGroup(2);
        boolean result2 = this.restManager.onArrive(group2);
        Assert.assertTrue(result2);
        Assert.assertNotNull(group2.getAssignedTable());
        Assert.assertEquals(group2.getAssignedTable().getSize(), 2);
        // Seat group of six
        CustomerGroup group6 = new CustomerGroup(6);
        boolean result6 = this.restManager.onArrive(group6);
        Assert.assertTrue(result6);
        Assert.assertNotNull(group6.getAssignedTable());
        Assert.assertEquals(group6.getAssignedTable().getSize(), 6);
        // Seat group of four
        CustomerGroup group4 = new CustomerGroup(4);
        boolean result4 = this.restManager.onArrive(group4);
        Assert.assertTrue(result4);
        Assert.assertNotNull(group4.getAssignedTable());
        Assert.assertEquals(group4.getAssignedTable().getSize(), 4);
        // Keep another group of six waiting
        CustomerGroup waitingGroup = new CustomerGroup(6);
        boolean resultWaiting = this.restManager.onArrive(waitingGroup);
        Assert.assertFalse(resultWaiting);
        Assert.assertNull(waitingGroup.getAssignedTable());
    }

    @Test
    public void testWaitAndSeat() {
        // Seat group of two
        CustomerGroup group2 = new CustomerGroup(2);
        boolean result2 = this.restManager.onArrive(group2);
        Assert.assertTrue(result2);
        Assert.assertNotNull(group2.getAssignedTable());
        Assert.assertEquals(group2.getAssignedTable().getSize(), 2);
        // Seat group of six
        CustomerGroup group6 = new CustomerGroup(6);
        boolean result6 = this.restManager.onArrive(group6);
        Assert.assertTrue(result6);
        Assert.assertNotNull(group6.getAssignedTable());
        Assert.assertEquals(group6.getAssignedTable().getSize(), 6);
        // Seat group of four
        CustomerGroup group4 = new CustomerGroup(4);
        boolean result4 = this.restManager.onArrive(group4);
        Assert.assertTrue(result4);
        Assert.assertNotNull(group4.getAssignedTable());
        Assert.assertEquals(group4.getAssignedTable().getSize(), 4);
        // Keep another group of six waiting
        CustomerGroup waitingGroup = new CustomerGroup(6);
        boolean resultWaiting = this.restManager.onArrive(waitingGroup);
        Assert.assertFalse(resultWaiting);
        Assert.assertNull(waitingGroup.getAssignedTable());
        // Leave group of four
        this.restManager.onLeave(group4);
        Assert.assertNull(group4.getAssignedTable());
        // Seat group of two
        CustomerGroup anotherGroup2 = new CustomerGroup(2);
        this.restManager.onArrive(anotherGroup2);
        Assert.assertNotNull(anotherGroup2.getAssignedTable());
        Assert.assertEquals(anotherGroup2.getAssignedTable().getSize(), 4);
    }

    @Test
    public void testRushHour() {
        // Seat group of two
        CustomerGroup group2 = new CustomerGroup(2);
        boolean result2 = this.restManager.onArrive(group2);
        Assert.assertTrue(result2);
        Assert.assertNotNull(group2.getAssignedTable());
        Assert.assertEquals(group2.getAssignedTable().getSize(), 2);
        // Seat group of six
        CustomerGroup group6 = new CustomerGroup(6);
        boolean result6 = this.restManager.onArrive(group6);
        Assert.assertTrue(result6);
        Assert.assertNotNull(group6.getAssignedTable());
        Assert.assertEquals(group6.getAssignedTable().getSize(), 6);
        // Seat group of four
        CustomerGroup group4 = new CustomerGroup(4);
        boolean result4 = this.restManager.onArrive(group4);
        Assert.assertTrue(result4);
        Assert.assertNotNull(group4.getAssignedTable());
        Assert.assertEquals(group4.getAssignedTable().getSize(), 4);
        // Keep another group of four waiting
        CustomerGroup waitingGroup = new CustomerGroup(4);
        boolean resultWaiting = this.restManager.onArrive(waitingGroup);
        Assert.assertFalse(resultWaiting);
        Assert.assertNull(waitingGroup.getAssignedTable());
        // Leave group of four
        this.restManager.onLeave(group4);
        Assert.assertNull(group4.getAssignedTable());
        // Seat group of two
        CustomerGroup anotherGroup2 = new CustomerGroup(2);
        this.restManager.onArrive(anotherGroup2);
        Assert.assertNotNull(anotherGroup2.getAssignedTable());
        Assert.assertEquals(anotherGroup2.getAssignedTable().getSize(), 4);
        // Leave group of two
        this.restManager.onLeave(group2);
        Assert.assertNull(group2.getAssignedTable());
        // Leave group of six
        this.restManager.onLeave(group6);
        Assert.assertNull(group6.getAssignedTable());
        // Seat the previous waiting group of four
        boolean seatWaitingGroupResult = this.restManager.onArrive(waitingGroup);
        Assert.assertTrue(seatWaitingGroupResult);
        Assert.assertNotNull(waitingGroup.getAssignedTable());
        Assert.assertEquals(waitingGroup.getAssignedTable().getSize(), 6);

    }


}
