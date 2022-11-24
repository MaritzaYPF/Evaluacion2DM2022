package com.example.ve16i04001.Models.Interfaces

import androidx.room.*
import com.example.ve16i04001.Models.UsuarioEntity

@Dao
interface UsuarioDao {

    @Insert
    fun addUsuario(usuarioEntity: UsuarioEntity)

    @Query("SELECT * FROM UsuarioEntity ORDER BY puntaje ASC LIMIT 3")
    fun getAll(): MutableList<UsuarioEntity>

    @Query("SELECT * FROM UsuarioEntity WHERE nickname=:nickname")
    fun login(nickname: String): Boolean

    @Query("SELECT puntaje FROM UsuarioEntity WHERE nickname=:nickname")
    fun valorPuntaje(nickname: String): Int


    @Update
    fun UpdateUser(entityUser: UsuarioEntity)
    @Query("UPDATE UsuarioEntity SET puntaje=:puntaje, intentos=:intentos WHERE nickname=:nickname")
    fun update(puntaje:String, intentos:String, nickname: String)



    @Query("SELECT * FROM UsuarioEntity ORDER BY puntaje ASC" )
    fun getAllUsuariosByPuntaje(): List<UsuarioEntity>

    @Query("DELETE FROM UsuarioEntity")
    fun deleteAllUsuarios()

    @Delete
    fun delete(usuarioEntity: UsuarioEntity)

}