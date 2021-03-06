package ShopzoneServer.common.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import ShopzoneServer.domain.Utente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
public class UserDetailsImpl implements UserDetails {

	private Utente utente;

	public UserDetailsImpl(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String getUsername() {
		return utente.getUsername();
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return utente.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> result = new ArrayList<>();

		if (utente.getNegozio() != null) {
			GrantedAuthorityImpl authorityImpl = new GrantedAuthorityImpl("negoziante");
			result.add(authorityImpl);
		} else {
			if (utente != null) {
				GrantedAuthorityImpl authorityImpl = new GrantedAuthorityImpl("base");
				result.add(authorityImpl);
			}
		}
		return result;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Utente getUtente() {
		return utente;
	}

}