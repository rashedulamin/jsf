package de.hsm.dataTable.gui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import de.hsm.dataTable.domain.Address;

@Component(value = "dataTableAddressBean")
@SessionScope
public class AddressBean implements Serializable{
	private List<Address> addresses;

    public AddressBean(){
        addresses = new ArrayList<>();
        fillAddresses();
    }

    public String deleteAddress(Address address) {
		addresses.remove(address);
        if (addresses.isEmpty()){
            fillAddresses();
        }
        return null;
	}

    private void fillAddresses(){
        addresses.add(new Address(98574, "Schmalkalden", "Blechhammer 9", "DE"));
        addresses.add(new Address(98574, "Schmalkalden", "Altmarkt 1", "DE"));
        addresses.add(new Address(99817, "Eisenach", "Frauenplan 21", "DE"));
    }


    public List<Address> getAddresses() {
        return addresses;
    }


}