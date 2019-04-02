package com.leek.wars.client.nav.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.AI;
import com.leek.wars.client.entities.responses.AisResponse;
import com.leek.wars.client.util.ais.AisHelper;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.bot.errors.ServerException;
import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;

public class SaveAisAction extends Action {

	private static final Logger logger = LoggerFactory.getLogger(SaveAisAction.class);

	private String farmerName;
	private String token;

	public SaveAisAction(AbstractMenu containingMenu, String farmerName, String token) {
		super(containingMenu);
		this.farmerName = farmerName;
		this.token = token;
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) {
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
			logger.error("", e);
		}

		return caller;
	}

	@Override
	public String getLabel() {
		return "Save AIs";
	}

}
