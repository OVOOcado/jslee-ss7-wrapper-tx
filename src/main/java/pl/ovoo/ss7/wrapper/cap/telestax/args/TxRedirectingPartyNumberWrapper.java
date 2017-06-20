/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.args;

import org.mobicents.protocols.ss7.cap.api.CAPException;
import org.mobicents.protocols.ss7.cap.api.isup.RedirectingPartyIDCap;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.RedirectingPartyNumberWrapper;

/**
 * OcCallingPartyNumberWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxRedirectingPartyNumberWrapper implements RedirectingPartyNumberWrapper {

    private final RedirectingPartyIDCap redirectingPartyNumber;

    public TxRedirectingPartyNumberWrapper(final RedirectingPartyIDCap redirectingPartyNumber) {
        this.redirectingPartyNumber = redirectingPartyNumber;
    }

    @Override
    public String getAddress() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber().getAddress();
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public Nature getNature() throws Ss7WrapperException {
        try {
            if (redirectingPartyNumber.getRedirectingNumber() != null) {
                return Nature.valueOf(redirectingPartyNumber.getRedirectingNumber().getNatureOfAddressIndicator());
            }
            return null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public NumberingPlan getNumberingPlan() throws Ss7WrapperException {
        try {
            if (redirectingPartyNumber.getRedirectingNumber() != null) {
                return NumberingPlan.valueOf(redirectingPartyNumber.getRedirectingNumber().getNumberingPlanIndicator());
            }
            return null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasAddress() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber() != null && redirectingPartyNumber.getRedirectingNumber().getAddress() != null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasNature() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber() != null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasNumberingPlan() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber() != null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public boolean hasPresentation() throws Ss7WrapperException {
        try {
            return redirectingPartyNumber.getRedirectingNumber() != null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    @Override
    public Presentation getPresentation() throws Ss7WrapperException {
        try {
            if (redirectingPartyNumber.getRedirectingNumber() != null) {
                return Presentation.valueOf(redirectingPartyNumber.getRedirectingNumber().getAddressRepresentationRestrictedIndicator());
            }
            return null;
        } catch (CAPException e) {
            throw new Ss7WrapperException(e);
        }
    }

    public RedirectingPartyIDCap getTxRedirectingPartyNumber() {
        return redirectingPartyNumber;
    }

	@Override
	public String toString() {
		return "TxRedirectingPartyNumberWrapper [redirectingPartyNumber=" + redirectingPartyNumber + "]";
	}
    
}
