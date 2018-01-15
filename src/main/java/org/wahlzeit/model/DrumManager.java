package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.wahlzeit.anonntations.PatternInstance;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.services.ObjectManager;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Work;


@PatternInstance(name = "Singelton", participants = {DrumManager.class })
public class DrumManager extends ObjectManager {
	
	protected static final DrumManager instance = new DrumManager();

	private static final Logger log = Logger.getLogger(PhotoManager.class.getName());
	
	protected Map<Integer, Drumset> DrumCache = new HashMap<Integer, Drumset>();
	protected Map<Integer, DrumType> TypeCache = new HashMap<Integer,DrumType>();
	
	private DrumManager(){}
	
	public static DrumManager getInstance(){
		return instance;
	}
	
	/**
	 * 
	 * @param id
	 * @return null if no Drumset with given id Exists
	 */
	public Drumset getSet(int id){
		return DrumCache.get(id);
	}
	
	/**
	 * 
	 * @param id
	 * @return null if no DrumType with given id Exists
	 */
	public DrumType getType(int id){
		return TypeCache.get(id);
	}
	
	public void addSet(Drumset set){
		if(set == null) throw new IllegalArgumentException("added Null as Drumset");
		DrumCache.put(set.getID(), set);
		saveSet(set);
		GlobalsManager.getInstance().saveGlobals();
	}
	
	public void addType(DrumType type){
		if(type == null) throw new IllegalArgumentException("added Null as DrumType");
		TypeCache.put(type.getID(), type);
		saveType(type);
		GlobalsManager.getInstance().saveGlobals();
	}
	
	
	public void  saveSet(Drumset set){
		updateObject(set);
	}
	
	public void saveType(DrumType type){
		updateObject(type);
	}
	
	public void saveAllSets(){
		DrumCache.forEach((id,set) -> saveSet(set));
	}
	
	public void saveAllTypes(){
		TypeCache.forEach((id,type) -> saveType(type));
	}
	
	
	/**
	 * as done in PhotoManager
	 */
	public void loadDrumsets() {
		Collection<Drumset> existingDrumsets = ObjectifyService.run(new Work<Collection<Drumset>>() {
			@Override
			public Collection<Drumset> run() {
				Collection<Drumset> existingDrumsets = new ArrayList<Drumset>();
				readObjects(existingDrumsets, Drumset.class);
				return existingDrumsets;
			}
		});

		for (Drumset drumset : existingDrumsets) {
			if (getSet(drumset.getID()) != null) {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Load Drumset with ID", drumset.getID() + "" ).toString());
				addSet(drumset);
			} else {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Already loaded Drumset", drumset.getID() + "").toString());
			}
		}

		log.info(LogBuilder.createSystemMessage().addMessage("All Drumsets loaded.").toString());
	}
	
	
	/**
	 * as done in PhotoManager
	 */
	public void loadTypes() {
		Collection<DrumType> existingTypes = ObjectifyService.run(new Work<Collection<DrumType>>() {
			@Override
			public Collection<DrumType> run() {
				Collection<DrumType> existingTypes = new ArrayList<DrumType>();
				readObjects(existingTypes, DrumType.class);
				return existingTypes;
			}
		});

		for (DrumType type : existingTypes) {
			if (getSet(type.getID()) != null) {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Load DrumType with ID", type.getID() + "" ).toString());
				addType(type);
			} else {
				log.config(LogBuilder.createSystemMessage().
						addParameter("Already loaded DrumType", type.getID() + "").toString());
			}
		}

		log.info(LogBuilder.createSystemMessage().addMessage("All Drumtypes loaded.").toString());
	}
	

}
