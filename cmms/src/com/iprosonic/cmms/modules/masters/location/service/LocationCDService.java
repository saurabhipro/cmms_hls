package com.iprosonic.cmms.modules.masters.location.service;

import java.util.List;

import com.iprosonic.cmms.modules.masters.client.dao.ClientMasterDaoImpl;
import com.iprosonic.cmms.modules.masters.client.domain.ClientMasterBean;
import com.iprosonic.cmms.modules.masters.location.dao.LocationmstDAO;
import com.iprosonic.cmms.modules.masters.location.domain.Locationmst;

public class LocationCDService {

	private LocationmstDAO	locationmstDAO	= null;

	public LocationCDService() {
		locationmstDAO = new LocationmstDAO();
	}

	public List<String> getUnitNameList() {
		return locationmstDAO.getLocationNameList();
	}

	public List<Locationmst> getLocationList() {
		return locationmstDAO.getLocation();
	}

	public boolean getLocationById(int id) {
		boolean b = locationmstDAO.getlocationId(id);
		return b;
	}

	public void editLocation(Locationmst bean) {
		locationmstDAO.editLocationById(bean);
	}

	public void saveLocationSer(Locationmst bean) {
		locationmstDAO.saveLocation(bean);
	}

	public void deleteClient(Locationmst bean) {
		locationmstDAO.deleteLocationById(bean);
	}

	public List<String> getUnitCode() {
		return locationmstDAO.getUnitCd();
	}
}
