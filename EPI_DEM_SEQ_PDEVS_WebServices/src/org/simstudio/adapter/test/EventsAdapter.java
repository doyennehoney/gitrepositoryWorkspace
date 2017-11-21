package org.simstudio.adapter.test;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.simstudio.model.Data;
import org.simstudio.model.Events;
import org.simstudio.model.Grid;

//public class EventsAdapter extends XmlAdapter<EventsAdapter.AdaptedEvents, Events> {
public class EventsAdapter extends XmlAdapter<Grid, Events> {
 
	 @Override
	 public Grid marshal(Events events){
		 Grid grid = null;
		 if (events instanceof Grid){
			 grid = (Grid) events;
		 }
		 //System.out.println("Grid value is ---"+grid.getDataGrid());
		 return grid;
	 }
//    public AdaptedEvents marshal(Events events)
//        throws Exception {
//        if (null == events) {
//            return null;
//        }
//        AdaptedEvents adaptedEvents = new AdaptedEvents();
//        if (events instanceof Grid) {
//        	Grid grid = (Grid) events;
//        	adaptedEvents.dataGrid = grid.getDataGrid();
//        	//adaptedEvents.setDataGrid(grid.getDataGrid());
//        	//System.out.println("datagrid  +++"+adaptedEvents.dataGrid);
//        	System.out.println("marshalled data Events  +++"+adaptedEvents.dataGrid);
//        	/*Data[][] dataGrid = adaptedEvents.dataGrid;
//        	
//        	for(int i=0; i<dataGrid.length; i++) {
//				 for(int j=0; j<dataGrid[i].length; j++) {
//					 System.out.println("Marshall adapted events : "+dataGrid[i][j]);
//				 }
//        	}*/
//        	
//        	
//        } else {
//            Data data = (Data) events;
//            adaptedEvents.infected = data.getInfected();
//            adaptedEvents.recovered = data.getRecovered();
//            adaptedEvents.size = data.getSize();
//            adaptedEvents.susceptible = data.getSusceptible();
//            
//        }
//        
//        return adaptedEvents;
//    }
 
    @Override
    public Events unmarshal(Grid grid){
    	//System.out.println("Returned Grid value is  +++++"+ grid.getDataGrid());
    	return grid;
    }
//    public Events unmarshal(AdaptedEvents adaptedEvents)
//        throws Exception {
//    	System.out.println("AdaptedEvents  --------"+adaptedEvents);
//    	if (null == adaptedEvents) {
//            return null;
//        }
//        if (null != adaptedEvents.dataGrid) {
//            Data data = new Data();
//            data.setInfected(adaptedEvents.infected);
//            data.setRecovered(adaptedEvents.recovered);
//            data.setSize(adaptedEvents.size);
//            data.setSusceptible(adaptedEvents.susceptible);   
//            System.out.println("unmarshalled data Events  +++"+adaptedEvents.dataGrid);
//        	
//            return data;
//        } else {
//            Grid grid = new Grid();
//            grid.setDataGrid(adaptedEvents.dataGrid);
//            
//            return grid;
//        }
//        
//        
//    }
 
    //@XmlRootElement(name="AdaptedEvents")
    @XmlType
    public static class AdaptedEvents {
 
    	@XmlElement(name="dataGrid")
    	public Data dataGrid[][];
    	
    	@XmlElement(name="size")
    	public double size;
    	//int grid[][];
    	
    	@XmlElement(name="susceptible")
    	double susceptible;
    	@XmlElement(name="infected")
    	double infected;
    	@XmlElement(name="recovered")
    	double recovered;
    	
    	public AdaptedEvents(){}

//		public Data[][] getDataGrid() {
//			return dataGrid;
//		}
//
//		public void setDataGrid(Data[][] dataGrid) {
//			this.dataGrid = dataGrid;
//		}
//
//		public double getSize() {
//			return size;
//		}
//
//		public void setSize(double size) {
//			this.size = size;
//		}
//
//		public double getSusceptible() {
//			return susceptible;
//		}
//
//		public void setSusceptible(double susceptible) {
//			this.susceptible = susceptible;
//		}
//
//		public double getInfected() {
//			return infected;
//		}
//
//		public void setInfected(double infected) {
//			this.infected = infected;
//		}
//
//		public double getRecovered() {
//			return recovered;
//		}
//
//		public void setRecovered(double recovered) {
//			this.recovered = recovered;
//		}
//    	
    	
//        @XmlAttribute
//        public String number;
// 
//        @XmlAttribute
//        public String street;
// 
//        @XmlAttribute
//        public String city;
// 
    }
 

}
