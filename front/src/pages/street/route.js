import Applayout from "@/layout/Applayout";
const routes = [
    {
        path: '/streets',
        component: Applayout,
        name: 'streets',
        meta: {
            title: 'Streets',
            icon: 'menu-fold'
        },
        children: [
            {
                path: 'list',
                component: () => import('./List'),
                name: 'Streets',
                meta: {
                    title: 'Streets List',
                }
            },
            {
                path: 'add',
                component: () => import('./form'),
                name: 'Streets',
                meta: {
                    title: 'Add Streets',
                }
            },
            {
                path: 'detail/:id',
                component: () => import('./detail'),
                name: 'Streets',
                meta: {
                    title: 'Add Streets',
                }
            }
        ]
    }
]

export default routes;