package com.zacharykirshbaum.moody.moody;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends Fragment {

    @Bind(R.id.edit_profile_picture_button) FloatingActionButton _editProfilePictureButton;
    @Bind(R.id.settings_button) FloatingActionButton _settingsButton;

    @Bind(R.id.edit_name_button) ImageButton _editNameButton;
    @Bind(R.id.confirm_name_button) ImageButton _confirmNameButton;

    @Bind(R.id.edit_email_button) ImageButton _editEmailButton;
    @Bind(R.id.confirm_email_button) ImageButton _confirmEmailButton;

    @Bind(R.id.edit_text_name) EditText _nameText;
    @Bind(R.id.edit_text_email) EditText _emailText;

    public ProfileFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.settings_button)
    public void onClickSettingsButton () {
        startActivity(new Intent(getActivity(), SettingsActivity.class));
    }

    @OnClick(R.id.edit_profile_picture_button)
    public void onClickEditProfilePictureButton() {

    }

    @OnClick(R.id.edit_name_button)
    public void onClickEditNameButton() {
//        _nameText.setCursorVisible(true);
//        _nameText.setFocusableInTouchMode(true);
//        _nameText.setInputType(InputType.TYPE_CLASS_TEXT);
//        _nameText.requestFocus(); //to trigger the soft input

        _editNameButton.setVisibility(View.GONE);
        _confirmNameButton.setVisibility(View.VISIBLE);

        _nameText.setEnabled(true);
    }

    @OnClick(R.id.confirm_name_button)
    public void onClickConfirmNameButton() {
        // trim content
        _nameText.setText(_nameText.getText().toString().trim());

        _confirmNameButton.setVisibility(View.GONE);
        _editNameButton.setVisibility(View.VISIBLE);

        _nameText.setEnabled(false);
    }

    @OnClick(R.id.edit_email_button)
    public void onClickEditEmailButton() {
        _editEmailButton.setVisibility(View.GONE);
        _confirmEmailButton.setVisibility(View.VISIBLE);

        _emailText.setEnabled(true);
    }

    @OnClick(R.id.confirm_email_button)
    public void onClickConfirmEmailButton() {
        // trim content
        _emailText.setText(_emailText.getText().toString().trim());

        _confirmEmailButton.setVisibility(View.GONE);
        _editEmailButton.setVisibility(View.VISIBLE);

        _emailText.setEnabled(false);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}