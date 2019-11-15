import React from 'react';
import renderer from 'react-test-renderer';

import ElementosDeAcesso from '..\src\component\ElementosDeAcesso.js';

describe('<ElementosDeAcesso />', () => {
    it('should match the snapshot', () => {
      const component = renderer.create(<ElementosDeAcesso />).toJSON();
      expect(component).toMatchSnapshot();
    });
  });