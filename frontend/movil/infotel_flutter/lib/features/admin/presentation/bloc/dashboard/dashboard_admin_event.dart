import 'package:equatable/equatable.dart';

abstract class DashboardAdminEvent extends Equatable {
  const DashboardAdminEvent();

  @override
  List<Object> get props => [];
}

class LoadDashboardEvent extends DashboardAdminEvent {}
