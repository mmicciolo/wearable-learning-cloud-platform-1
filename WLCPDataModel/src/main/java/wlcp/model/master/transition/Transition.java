package wlcp.model.master.transition;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import wlcp.model.master.Game;
import wlcp.model.master.connection.Connection;

/**
 * Entity implementation class for Entity: Transition
 *
 */
@Entity
@Table(name = "TRANSITION")
public class Transition implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "TRANSITION_ID")
	private String transitionId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "GAME")
	@JsonIgnore
	private Game game;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CONNECTION")
	@JsonIgnoreProperties(value= {"game", "connectionFrom", "connectionTo", "backwardsLoop", "transition"})
	private Connection connection;
	
	@ElementCollection()
    @CollectionTable(name = "ACTIVE_TRANSITIONS")
    @MapKeyColumn(name = "SCOPE")
	private Map<String, String> activeTransitions = new HashMap<String, String>();
	
	@ElementCollection()
    @CollectionTable(name = "SINGLE_BUTTON_PRESS")
    @MapKeyColumn(name = "SCOPE")
	private Map<String, SingleButtonPress> singleButtonPresses = new HashMap<String, SingleButtonPress>();
	
	@OneToMany(mappedBy="transition", orphanRemoval = true, cascade = CascadeType.PERSIST)
	@MapKey(name = "scope")
	private Map<String, SequenceButtonPress> sequenceButtonPresses = new HashMap<String, SequenceButtonPress>();
	
	@OneToMany(mappedBy="transition", orphanRemoval = true, cascade = CascadeType.PERSIST)
	@MapKey(name = "scope")
	private Map<String, KeyboardInput> keyboardInputs = new HashMap<String, KeyboardInput>();

	public Transition() {
		super();
	}

	public Transition(String transitionId, Game game, Connection connection, Map<String, String> activeTransitions,
			Map<String, SingleButtonPress> singleButtonPresses,
			Map<String, SequenceButtonPress> sequenceButtonPresses,
			Map<String, KeyboardInput> keyboardInputs) {
		super();
		this.transitionId = transitionId;
		this.game = game;
		this.connection = connection;
		this.activeTransitions = activeTransitions;
		this.singleButtonPresses = singleButtonPresses;
		this.sequenceButtonPresses = sequenceButtonPresses;
		this.keyboardInputs = keyboardInputs;
	}

	public String getTransitionId() {
		return transitionId;
	}

	public void setTransitionId(String transitionId) {
		this.transitionId = transitionId;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public Map<String, String> getActiveTransitions() {
		return activeTransitions;
	}

	public void setActiveTransitions(Map<String, String> activeTransitions) {
		this.activeTransitions = activeTransitions;
	}

	public Map<String, SingleButtonPress> getSingleButtonPresses() {
		return singleButtonPresses;
	}

	public void setSingleButtonPresses(Map<String, SingleButtonPress> singleButtonPresses) {
		this.singleButtonPresses = singleButtonPresses;
	}

	public Map<String, SequenceButtonPress> getSequenceButtonPresses() {
		return sequenceButtonPresses;
	}

	public void setSequenceButtonPresses(Map<String, SequenceButtonPress> sequenceButtonPresses) {
		this.sequenceButtonPresses = sequenceButtonPresses;
	}

	public Map<String, KeyboardInput> getKeyboardInputs() {
		return keyboardInputs;
	}

	public void setKeyboardInputs(Map<String, KeyboardInput> keyboardInputs) {
		this.keyboardInputs = keyboardInputs;
	}

}
