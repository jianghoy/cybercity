package com.jianghoy.cybercity2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class OnBoardingPageAdapter extends FragmentPagerAdapter {
    // 2 pages total
    private static int NUM_ITEMS = 2;


    public OnBoardingPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return LoginFragment.newInstance();
        } else if (position == 1) {
            return RegisterFragment.newInstance();
        }
        return  null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Login";
        } else if (position == 1) {
            return "Register";
        }
        return null;
    }
    // return total  pages (2)
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
