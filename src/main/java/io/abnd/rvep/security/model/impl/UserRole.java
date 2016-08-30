package io.abnd.rvep.security.model.impl;

import java.io.Serializable;
import javax.persistence.*;

import io.abnd.rvep.user.model.RvepUser;


/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Table(name="user_role")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to RvepRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_role_id")
	private RvepRole rvepRole;

	//bi-directional many-to-one association to RvepUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rvep_user_id")
	private RvepUser rvepUser;

	public UserRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RvepRole getRvepRole() {
		return this.rvepRole;
	}

	public void setRvepRole(RvepRole rvepRole) {
		this.rvepRole = rvepRole;
	}

	public RvepUser getRvepUser() {
		return this.rvepUser;
	}

	public void setRvepUser(RvepUser rvepUser) {
		this.rvepUser = rvepUser;
	}

}