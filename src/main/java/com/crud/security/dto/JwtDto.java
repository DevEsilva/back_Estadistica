package com.crud.security.dto;

import com.crud.dto.AvatarDTO;
import com.crud.entity.Avatar;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDto {

    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private String nombre;
    private String establecimiento;
    private Collection<? extends GrantedAuthority> authorities;
    private AvatarDTO avatar;

    public JwtDto(String token, String nombreUsuario,String nombre, String establecimiento, Collection<? extends GrantedAuthority> authorities, AvatarDTO avatar) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.establecimiento = establecimiento;
        this.authorities = authorities;
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public AvatarDTO getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarDTO avatar) {
        this.avatar = avatar;
    }

 

    
}
