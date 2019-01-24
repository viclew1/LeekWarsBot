package com.leek.wars.client.cmd.nav.actions.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.cmd.nav.actions.Action;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.entities.AI;
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
			List<AI> ais = aisResponse.getAis();
			List<AI> completeAis = new ArrayList<>(ais.size());
			for (AI ai : ais) {
				AI completeAi = RequestProcessor.INSTANCE.getAi(ai.getId(), token).getAi();
				completeAis.add(completeAi);
			}
			AisHelper.INSTANCE.saveAIs(farmerName, completeAis, aisResponse.getFolders());
		} catch (ServerException | IOException e) {
			throw new ActionException(e);
		}
		
		return caller;
	}

}
