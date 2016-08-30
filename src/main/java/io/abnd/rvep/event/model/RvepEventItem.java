package io.abnd.rvep.event.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rvep_event_item database table.
 * 
 */
@Entity
@Table(name="rvep_event_item")
@NamedQuery(name="RvepEventItem.findAll", query="SELECT r FROM RvepEventItem r")
public class RvepEventItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_time")
	private Date dateTime;

	private String description;

	private byte enabled;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_on")
	private Date updatedOn;

	//bi-directional many-to-many association to RollingVote
	@ManyToMany(mappedBy="rvepEventItems")
	private List<RollingVote> rollingVotes;

	//bi-directional many-to-many association to EventItemTask
	@ManyToMany
	@JoinTable(
		name="rvep_event_item_task"
		, joinColumns={
			@JoinColumn(name="rvep_event_item_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="event_item_task_id")
			}
		)
	private List<EventItemTask> eventItemTasks;

	//bi-directional many-to-one association to RvepEvent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_event_id")
	private RvepEvent rvepEvent;

	//bi-directional many-to-one association to RvepLocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_location_id")
	private RvepLocation rvepLocation;

	//bi-directional many-to-many association to Suggestion
	@ManyToMany
	@JoinTable(
		name="rvep_event_item_suggestion"
		, joinColumns={
			@JoinColumn(name="rvep_event_item_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="suggestion_id")
			}
		)
	private List<Suggestion> suggestions;

	//bi-directional many-to-one association to TodoList
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="todo_list_id")
	private TodoList todoList;

	public RvepEventItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<RollingVote> getRollingVotes() {
		return this.rollingVotes;
	}

	public void setRollingVotes(List<RollingVote> rollingVotes) {
		this.rollingVotes = rollingVotes;
	}

	public List<EventItemTask> getEventItemTasks() {
		return this.eventItemTasks;
	}

	public void setEventItemTasks(List<EventItemTask> eventItemTasks) {
		this.eventItemTasks = eventItemTasks;
	}

	public RvepEvent getRvepEvent() {
		return this.rvepEvent;
	}

	public void setRvepEvent(RvepEvent rvepEvent) {
		this.rvepEvent = rvepEvent;
	}

	public RvepLocation getRvepLocation() {
		return this.rvepLocation;
	}

	public void setRvepLocation(RvepLocation rvepLocation) {
		this.rvepLocation = rvepLocation;
	}

	public List<Suggestion> getSuggestions() {
		return this.suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public TodoList getTodoList() {
		return this.todoList;
	}

	public void setTodoList(TodoList todoList) {
		this.todoList = todoList;
	}

}