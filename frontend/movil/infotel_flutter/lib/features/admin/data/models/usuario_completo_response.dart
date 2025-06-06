import 'package:infotel_flutter/features/admin/data/models/authority_response.dart';
import 'package:infotel_flutter/features/admin/data/models/persona_response.dart';
import 'package:infotel_flutter/features/admin/data/models/rol_response.dart';

class UsuarioCompletoResponse {
  int idUsuario;
  String? username;
  String? password;
  String? estado;
  RolResponse? rol;
  PersonaResponse? persona;
  bool? enabled;
  bool? accountNonLocked;
  bool? accountNonExpired;
  bool? credentialsNonExpired;
  List<AuthorityResponse?>? authorities;

  String? fechaCreacionUsuario;
  String? fechaModificacionUsuario;

  UsuarioCompletoResponse({
    required this.idUsuario,
    required this.username,
    required this.password,
    required this.estado,
    required this.rol,
    required this.persona,
    required this.fechaCreacionUsuario,
    required this.fechaModificacionUsuario,
    this.enabled,
    this.authorities,
    this.accountNonLocked,
    this.accountNonExpired,
    this.credentialsNonExpired,
  });

  factory UsuarioCompletoResponse.fromJson(Map<String, dynamic>? json) {
    if (json == null) {
      throw ArgumentError("json is null");
    }

    return UsuarioCompletoResponse(
      idUsuario: json['idUsuario'] ?? 0,
      username: json['username'],
      password: json['password'],
      estado: json['estado'],
      rol: json['rol'] != null ? RolResponse.fromJson(json['rol']) : null,
      persona: json['persona'] != null
          ? PersonaResponse.fromJson(json['persona'])
          : null,
      fechaCreacionUsuario: json['fechaCreacionUsuario'],
      fechaModificacionUsuario: json['fechaModificacionUsuario'],
      enabled: json['enabled'],
      accountNonLocked: json['accountNonLocked'],
      accountNonExpired: json['accountNonExpired'],
      credentialsNonExpired: json['credentialsNonExpired'],
      authorities: (json['authorities'] as List<dynamic>?)
          ?.map((e) => e == null
          ? null
          : AuthorityResponse.fromJson(e as Map<String, dynamic>))
          .toList() ??
          [],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'idUsuario': idUsuario,
      'username': username,
      'password': password,
      'estado': estado,
      'rol': rol?.toJson(),
      'persona': persona?.toJson(),
      'fechaCreacionUsuario': fechaCreacionUsuario,
      'fechaModificacionUsuario': fechaModificacionUsuario,
      'authorities': authorities?.map((e) => e?.toJson()).toList(),
      'enabled': enabled,
      'accountNonLocked': accountNonLocked,
      'accountNonExpired': accountNonExpired,
      'credentialsNonExpired': credentialsNonExpired,
    };
  }
}