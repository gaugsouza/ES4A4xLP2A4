import React from 'react';
import renderer from 'react-test-renderer';

import TelaInicial from '..\src\component\TelaInicial.js';

describe('<TelaInicial />', () => {
    it('should match the snapshot', () => {
      const component = renderer.create(<TelaInicial />).toJSON();
      expect(component).toMatchSnapshot();
    });
  });