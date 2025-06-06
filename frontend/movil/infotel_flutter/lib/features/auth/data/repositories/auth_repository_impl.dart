import 'package:infotel_flutter/features/auth/data/datasources/remote/auth_api_client.dart';
import 'package:infotel_flutter/features/auth/data/models/login_dto.dart';
import 'package:infotel_flutter/features/auth/data/models/login_response.dart';
import 'package:infotel_flutter/features/auth/data/models/register_dto.dart';
import 'package:infotel_flutter/features/auth/domain/repositories/auth_repository.dart';

class AuthRepositoryImpl implements AuthRepository {
  final AuthApiClient apiClient;

  AuthRepositoryImpl({required this.apiClient});

  @override
  Future<LoginResponse> login(LoginDto loginDto) async {
    try {
      final response = await apiClient.login(loginDto);
      return response;
    } catch (e) {
      rethrow;
    }
  }

  @override
  Future<LoginResponse> register(RegisterDto registerDto) async {
    try{
      final response = await apiClient.register(registerDto);
      return response;
    } catch (e){
      rethrow;
    }
  }
}