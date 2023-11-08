import { HomePage, TasksPage, ProfilePage, GroupPage, PersonPage, TipoGroupPage } from './pages';
import { withNavigationWatcher } from './contexts/navigation';

const routes = [
    {
        path: '/tasks',
        element: TasksPage
    },
    {
        path: '/profile',
        element: ProfilePage
    },
    {
        path: '/home',
        element: HomePage
    },
    {
        path: '/groups',
        element:GroupPage
    },
    {
        path: '/persons',
        element: PersonPage
    },
    {
        path: '/tipos',
        element: TipoGroupPage
    }
];

export default routes.map(route => {
    return {
        ...route,
        element: withNavigationWatcher(route.element, route.path)
    };
});
