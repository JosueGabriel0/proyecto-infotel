import 'package:get_it/get_it.dart';
import 'package:dio/dio.dart';
import 'package:infotel_flutter/features/auth/data/datasources/remote/auth_api_client.dart';
import 'package:infotel_flutter/features/auth/data/repositories/auth_repository_impl.dart';
import 'package:infotel_flutter/features/auth/domain/repositories/auth_repository.dart';
import 'package:infotel_flutter/features/auth/domain/usecases/login_usecase.dart';
import 'package:infotel_flutter/features/auth/domain/usecases/register_usecase.dart';

final getIt = GetIt.instance;

void injectAuthDependencies() {
  // ApiClient sin interceptor
  getIt.registerLazySingleton<AuthApiClient>(
        () => AuthApiClient(getIt<Dio>(instanceName: "noAuth")),
    instanceName: "noAuthClient",
  );

  // Repositorio de Auth usando ApiClient sin interceptor
  getIt.registerLazySingleton<AuthRepository>(
        () => AuthRepositoryImpl(apiClient: getIt<AuthApiClient>(instanceName: "noAuthClient")),
  );

  getIt.registerLazySingleton<LoginUseCase>(
        () => LoginUseCase(authRepository: getIt<AuthRepository>()),
  );

  getIt.registerLazySingleton<RegisterUseCase>(
        () => RegisterUseCase(authRepository: getIt<AuthRepository>()),
  );
}