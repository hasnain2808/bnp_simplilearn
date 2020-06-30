package com.app.bo.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.bo.PlayerBO;
import com.app.dao.PlayerDAO;
import com.app.dao.impl.PlayerDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Player;

public class PlayerBoImpl implements PlayerBO {
//private static Map<Integer, Player> playerMap=new HashMap<>();
//private static int count=0;
	private PlayerDAO playerDAO = new PlayerDAOImpl();

	@Override
	public Player createPlayer(Player player) throws BusinessException {
		// write validations
//		player.setId(++count);
//		playerMap.put(player.getId(), player);
		if (!isValidId(player.getId())) {
			throw new BusinessException("Entered Player Id " + player.getId() + " is invalid");
		}
		if (!isValidAge(player.getAge())) {
			throw new BusinessException("Entered Player Age " + player.getAge() + " is invalid");
		}
		if (!isValidName(player.getName())) {
			throw new BusinessException("Entered Player Name " + player.getName() + " is invalid");
		}

		// code here for DAO
		player = playerDAO.createPlayer(player);
		return player;
	}

	private boolean isValidAge(int age) {
		boolean b = true;
		if (age < 18 || age > 45) {
			b = false;
		}
		return b;
	}

	private boolean isValidId(int id) {
		boolean b = false;
		if (id > 99 && id < 1000) {
			b = true;
		}
		return b;
	}

	private boolean isValidName(String name) {
		boolean b = false;
		if (name.matches("[a-zA-Z]{3,30}")) {
			b = true;
		}
		return b;
	}

	private boolean isValidTeamName(String teamname) {
		boolean b = false;
		if (teamname.matches("[a-zA-Z]{3,30}")) {
			b = true;
		}
		return b;
	}

	@Override
	public Player getPlayerById(int id) throws BusinessException {
		Player player = null;
//		if(playerMap.containsKey(id)) {
//			player=playerMap.get(id);
//		}else {
//			throw new BusinessException("Player with id "+id+" not found");
//		}
		if (isValidId(id)) {
			player = playerDAO.getPlayerById(id);
		} else {
			throw new BusinessException("Entered Id " + id + " is invalid");
		}
		return player;
	}

	@Override
	public void removePlayerById(int id) throws BusinessException {
		Player player = null;
		if (isValidId(id)) {
			playerDAO.removePlayerById(id);
		} else {
			throw new BusinessException("Entered Id " + id + " is invalid");
		}
	}

	@Override
	public List<Player> getAllPlayers() throws BusinessException {
		List<Player> playerList = null;
		playerList = playerDAO.getAllPlayers();
		return playerList;
	}

	@Override
	public List<Player> getPlayersByName(String name) throws BusinessException {
		List<Player> playerList = null;
		if (isValidName(name)) {
			playerList = playerDAO.getPlayersByName(name);
		} else {
			throw new BusinessException("Entered name " + name + "is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByTeamName(String teamname) throws BusinessException {
		List<Player> playerList = null;
		if (isValidTeamName(teamname)) {
			playerList = playerDAO.getPlayersByTeamName(teamname);
		} else {
			throw new BusinessException("Entered teamname " + teamname + "is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByAge(int age) throws BusinessException {
		List<Player> playerList = null;
		if (isValidAge(age)) {
			playerList = playerDAO.getPlayersByAge(age);
		} else {
			throw new BusinessException("Entered age " + age + "is invalid");
		}
		return playerList;
	}

	@Override
	public List<Player> getPlayersByGender(String gender) throws BusinessException {
		List<Player> playerList = null;
		if (isValidGender(gender)) {
			playerList = playerDAO.getPlayersByGender(gender);
		} else {
			throw new BusinessException("Entered gender " + gender + "is invalid");
		}
		return playerList;
	}

	private boolean isValidGender(String gender) {
		boolean b = false;

		if (gender.matches("[mMfFoO]{1}")) {
			b = true;
		}
		return b;
	}

	@Override
	public List<Player> getPlayersByAgeRange(int upper, int lower) throws BusinessException {
		List<Player> playerList = null;
		if (isValidAge(lower) && isValidAge(upper)) {
			playerList = playerDAO.getPlayersByAgeRange(upper, lower);
		} else {
			throw new BusinessException("Entered age " + upper + " and " + lower + " is invalid");
		}
		return playerList;
	}
}
