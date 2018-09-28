package com.leek.wars.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.Error;
import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.entities.responses.Response;
import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.GlobalProperties;
import com.leek.wars.client.util.exceptions.MissingParameterException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.parameters.Parameter;
import com.leek.wars.client.util.rest.RequestProcessor;

public class AppCli {

	private static final Logger logger = LoggerFactory.getLogger(AppCli.class);


	private static final Parameter PATH_PARAM = new Parameter("global.infos.path", true);

	public static void main(String[] args) throws ServerException, IOException {
		try {
			initParams(PATH_PARAM);
		} catch (MissingParameterException e) {
			logger.error("Missing parameters", e);
			return;
		}

		logger.info("Params OK");

		try {
			GlobalProperties.INSTANCE.init(PATH_PARAM.getValue());
		} catch (IOException e) {
			logger.error("Can't init global properties", e);
			return;
		}

		SessionResponse session = RequestProcessor.INSTANCE.getSession();
		Response farmerRegisterResponse = RequestProcessor.INSTANCE.registerFarmerTournament(session.getToken());
		boolean registerOk = farmerRegisterResponse.isSuccess() || farmerRegisterResponse.getError() == Error.ALREADY_REGISTERED;
		logger.info("Farmer tournament register : {}", registerOk);

		for (Leek l : session.getFarmer().getLeeks().values()) {
			logger.info("-------------");
			logger.info("Leek : {}", l);

			Response leekRegisterResponse = RequestProcessor.INSTANCE.registerLeekTournament(l, session.getToken());
			boolean leekRegisterOk = leekRegisterResponse.isSuccess() || leekRegisterResponse.getError() == Error.ALREADY_REGISTERED;
			logger.info("Leek {} tournament register : {}", l.getName(), leekRegisterOk);
		}

		logger.info("#####################################");

		for (Leek l : session.getFarmer().getLeeks().values()) {
			logger.info("-------------");
			logger.info("Leek : {}", l);


			for (int i = 0 ; i < 25 ; i++) {
				OpponentLeeksResponse opponents = RequestProcessor.INSTANCE.getLeekOpponents(l, session.getToken());

				Leek chosenOpponent = selectOpponent(opponents.getOpponents());
				logger.info("Chosen opponent : {}", chosenOpponent);

				RequestProcessor.INSTANCE.startLeekFight(l, chosenOpponent, session.getToken());
			}
		}
	}

	private static Leek selectOpponent(List<Leek> opponents) {
		if (opponents.isEmpty()) {
			return null;
		}
		
		opponents.sort((l1, l2) -> getValue(l1) - getValue(l2));
		
		return opponents.get(0);
	}
	
	private static int getValue(Leek leek) {
		return leek.getLevel() * leek.getLevel() + leek.getTalent();
	}

	public static void initParams(Parameter... parameters) throws MissingParameterException {
		List<String> missingParameters = new ArrayList<>();
		for (Parameter p : parameters) {
			String value = System.getProperty(p.getKey());
			if (p.isRequired() && value == null) {
				missingParameters.add(p.getKey());
				continue;
			}
			p.setValue(value);
		}
		if (!missingParameters.isEmpty()) {
			throw new MissingParameterException(missingParameters);
		}
	}

}
