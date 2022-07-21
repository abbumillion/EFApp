package com.app.efa.views;


import com.app.efa.components.appnav.AppNav;
import com.app.efa.components.appnav.AppNavItem;
import com.app.efa.views.about.AboutView;
import com.app.efa.views.chat.ChatView;
import com.app.efa.views.contactus.ContactUsView;
import com.app.efa.views.customers.CustomersView;
import com.app.efa.views.dashboard.DashboardView;
import com.app.efa.views.freelancers.FreelancersView;
import com.app.efa.views.jobapplications.JobApplicationsView;
import com.app.efa.views.jobs.JobsView;
import com.app.efa.views.profile.ProfileView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.router.PageTitle;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        addToDrawer(createDrawerContent());
    }

    private Component createHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.addClassNames("view-toggle");
        toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames("view-title");

        Header header = new Header(toggle, viewTitle);
        header.addClassNames("view-header");
        return header;
    }

    private Component createDrawerContent() {
        H2 appName = new H2("EFA");
        appName.addClassNames("app-name");

        com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
                createNavigation(), createFooter());
        section.addClassNames("drawer-section");
        return section;
    }

    private AppNav createNavigation() {
        AppNav nav = new AppNav();
        nav.addClassNames("app-nav");

        nav.addItem(new AppNavItem("Dashboard", DashboardView.class, "la la-chart-area"));
        nav.addItem(new AppNavItem("JobApplications", JobApplicationsView.class, "la la-list"));
        nav.addItem(new AppNavItem("Jobs", JobsView.class, "la la-list"));
        nav.addItem(new AppNavItem("Freelancers", FreelancersView.class, "la la-th"));
        nav.addItem(new AppNavItem("Customers", CustomersView.class, "la la-th"));
        nav.addItem(new AppNavItem("Chat", ChatView.class, "la la-comments"));
        nav.addItem(new AppNavItem("Profile", ProfileView.class, "la la-user"));
        nav.addItem(new AppNavItem("Contact Us", ContactUsView.class, "la la-credit-card"));
        nav.addItem(new AppNavItem("About", AboutView.class, "la la-user"));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        layout.addClassNames("app-nav-footer");

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
