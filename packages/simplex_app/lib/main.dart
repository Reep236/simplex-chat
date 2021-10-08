import 'package:flutter/material.dart';
import 'package:simplex_chat/app_routes.dart';
import 'package:simplex_chat/constants.dart';
import 'package:simplex_chat/custom_scroll_behavior.dart';
import 'package:simplex_chat/views/contacts/add_contact_view.dart';
import 'package:simplex_chat/views/group/add_group_view.dart';
import 'package:simplex_chat/views/onBoarding/intro_view.dart';
import 'package:simplex_chat/views/scanInvitation/scan_invitation_view.dart';
import 'package:simplex_chat/views/setup_profile_view.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'SimpleX Chat',
      theme: ThemeData(
        primarySwatch: Colors.teal,
        primaryColor: kPrimaryColor,
        accentColor: kPrimaryColor,
      ),
      builder: (context, widget) {
        return ScrollConfiguration(
          behavior: ScrollBehaviorModified(),
          child: widget!,
        );
      },
      initialRoute: AppRoutes.intro,
      routes: <String, WidgetBuilder>{
        AppRoutes.intro: (_) => IntroView(),
        AppRoutes.setupProfile: (_) => SetupProfileView(),
        AppRoutes.addContact: (_) => AddContactView(),
        AppRoutes.scanInvitation: (_) => ScanInvitationView(),
        AppRoutes.addGroup: (_) => AddGroupView(),
      },
    );
  }
}