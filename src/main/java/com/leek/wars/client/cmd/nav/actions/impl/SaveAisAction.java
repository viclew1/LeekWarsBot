package com.leek.wars.client.cmd.nav.actions.impl;

import java.io.IOException;

import com.leek.wars.client.cmd.nav.actions.Action;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.entities.responses.AisResponse;
import com.leek.wars.client.util.ais.AisHelper;
import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

public class SaveAisAction extends Action {

	private String farmerName;
	private String token;
	
	public SaveAisAction(AbstractMenu containingMenu, String farmerName, String token) {
		super(containingMenu, "Save AIs");
		this.farmerName = farmerName;
		this.token = token;
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) throws ActionException {
		try {
			AisResponse aisResponse = RequestProcessor.INSTANCE.getFarmerAis(token);
			AisHelper.INSTANCE.saveAIs(farmerName, aisResponse.getAis(), aisResponse.getFolders());
		} catch (ServerException | IOException e) {
			throw new ActionException(e);
		}
		
		return caller;
	}

}
