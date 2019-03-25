package com.leek.wars.client.nav.actions;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;
import fr.lewon.client.util.input.Choice;
import fr.lewon.client.util.input.UserInputUtil;

public class ManualFightAction extends Action {

	private static final Logger logger = LoggerFactory.getLogger(ManualFightAction.class);
	
	private Leek leek;
	private String token;
	
	public ManualFightAction(AbstractMenu containingMenu, String token, Leek leek) {
		super(containingMenu);
		this.leek = leek;
		this.token = token;
	}

	@Override
	public AbstractMenu processAction(AbstractMenu caller) {
		try {
			OpponentLeeksResponse olr = RequestProcessor.INSTANCE.getLeekOpponents(leek.getId(), token);
			List<Choice<Leek>> opponentLeeks = olr.getOpponents().stream()
					.map(l -> new Choice<>(l.toSimpleString(), l))
					.collect(Collectors.toList());
			Leek choice = UserInputUtil.INSTANCE.askChoice("Opponents : ", true, opponentLeeks);
			if (choice == null) {
				return caller;
			}
			
			RequestProcessor.INSTANCE.startLeekFight(leek.getId(), leek.getId(), token);
		} catch (ServerException | IOException e) {
			logger.error("", e);
		}
		return caller;
	}

	@Override
	public String getLabel() {
		return "Manual Fight";
	}

}
